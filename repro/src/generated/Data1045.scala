package generated

final case class Data1045(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1045 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1045 = copy(value = value * k)
  def addTag(t: String): Data1045 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1045 = copy(meta = meta.updated(k, v))
  def merge(other: Data1045): Data1045 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1045 {
  given Ordering[Data1045] = Ordering.by(_.id)
  def empty: Data1045 = Data1045(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1045 =
    Data1045(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1045] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
