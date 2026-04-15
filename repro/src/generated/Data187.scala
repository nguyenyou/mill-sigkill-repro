package generated

final case class Data187(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data187 = copy(name = name.toUpperCase)
  def scale(k: Double): Data187 = copy(value = value * k)
  def addTag(t: String): Data187 = copy(tags = t :: tags)
  def put(k: String, v: String): Data187 = copy(meta = meta.updated(k, v))
  def merge(other: Data187): Data187 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data187 {
  given Ordering[Data187] = Ordering.by(_.id)
  def empty: Data187 = Data187(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data187 =
    Data187(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data187] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
