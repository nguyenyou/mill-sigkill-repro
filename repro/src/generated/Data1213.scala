package generated

final case class Data1213(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1213 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1213 = copy(value = value * k)
  def addTag(t: String): Data1213 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1213 = copy(meta = meta.updated(k, v))
  def merge(other: Data1213): Data1213 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1213 {
  given Ordering[Data1213] = Ordering.by(_.id)
  def empty: Data1213 = Data1213(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1213 =
    Data1213(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1213] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
