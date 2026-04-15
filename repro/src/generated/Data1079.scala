package generated

final case class Data1079(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1079 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1079 = copy(value = value * k)
  def addTag(t: String): Data1079 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1079 = copy(meta = meta.updated(k, v))
  def merge(other: Data1079): Data1079 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1079 {
  given Ordering[Data1079] = Ordering.by(_.id)
  def empty: Data1079 = Data1079(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1079 =
    Data1079(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1079] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
