package generated

final case class Data277(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data277 = copy(name = name.toUpperCase)
  def scale(k: Double): Data277 = copy(value = value * k)
  def addTag(t: String): Data277 = copy(tags = t :: tags)
  def put(k: String, v: String): Data277 = copy(meta = meta.updated(k, v))
  def merge(other: Data277): Data277 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data277 {
  given Ordering[Data277] = Ordering.by(_.id)
  def empty: Data277 = Data277(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data277 =
    Data277(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data277] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
