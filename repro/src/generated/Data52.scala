package generated

final case class Data52(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data52 = copy(name = name.toUpperCase)
  def scale(k: Double): Data52 = copy(value = value * k)
  def addTag(t: String): Data52 = copy(tags = t :: tags)
  def put(k: String, v: String): Data52 = copy(meta = meta.updated(k, v))
  def merge(other: Data52): Data52 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data52 {
  given Ordering[Data52] = Ordering.by(_.id)
  def empty: Data52 = Data52(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data52 =
    Data52(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data52] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
