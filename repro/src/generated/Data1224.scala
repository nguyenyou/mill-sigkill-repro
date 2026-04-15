package generated

final case class Data1224(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1224 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1224 = copy(value = value * k)
  def addTag(t: String): Data1224 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1224 = copy(meta = meta.updated(k, v))
  def merge(other: Data1224): Data1224 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1224 {
  given Ordering[Data1224] = Ordering.by(_.id)
  def empty: Data1224 = Data1224(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1224 =
    Data1224(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1224] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
