package generated

final case class Data1104(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1104 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1104 = copy(value = value * k)
  def addTag(t: String): Data1104 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1104 = copy(meta = meta.updated(k, v))
  def merge(other: Data1104): Data1104 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1104 {
  given Ordering[Data1104] = Ordering.by(_.id)
  def empty: Data1104 = Data1104(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1104 =
    Data1104(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1104] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
