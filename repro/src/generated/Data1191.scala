package generated

final case class Data1191(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1191 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1191 = copy(value = value * k)
  def addTag(t: String): Data1191 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1191 = copy(meta = meta.updated(k, v))
  def merge(other: Data1191): Data1191 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1191 {
  given Ordering[Data1191] = Ordering.by(_.id)
  def empty: Data1191 = Data1191(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1191 =
    Data1191(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1191] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
