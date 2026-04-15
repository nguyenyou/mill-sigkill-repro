package generated

final case class Data526(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data526 = copy(name = name.toUpperCase)
  def scale(k: Double): Data526 = copy(value = value * k)
  def addTag(t: String): Data526 = copy(tags = t :: tags)
  def put(k: String, v: String): Data526 = copy(meta = meta.updated(k, v))
  def merge(other: Data526): Data526 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data526 {
  given Ordering[Data526] = Ordering.by(_.id)
  def empty: Data526 = Data526(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data526 =
    Data526(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data526] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
