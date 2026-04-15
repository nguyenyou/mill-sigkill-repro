package generated

final case class Data1163(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1163 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1163 = copy(value = value * k)
  def addTag(t: String): Data1163 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1163 = copy(meta = meta.updated(k, v))
  def merge(other: Data1163): Data1163 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1163 {
  given Ordering[Data1163] = Ordering.by(_.id)
  def empty: Data1163 = Data1163(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1163 =
    Data1163(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1163] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
