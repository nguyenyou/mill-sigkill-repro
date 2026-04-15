package generated

final case class Data910(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data910 = copy(name = name.toUpperCase)
  def scale(k: Double): Data910 = copy(value = value * k)
  def addTag(t: String): Data910 = copy(tags = t :: tags)
  def put(k: String, v: String): Data910 = copy(meta = meta.updated(k, v))
  def merge(other: Data910): Data910 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data910 {
  given Ordering[Data910] = Ordering.by(_.id)
  def empty: Data910 = Data910(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data910 =
    Data910(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data910] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
