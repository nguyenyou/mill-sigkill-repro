package generated

final case class Data831(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data831 = copy(name = name.toUpperCase)
  def scale(k: Double): Data831 = copy(value = value * k)
  def addTag(t: String): Data831 = copy(tags = t :: tags)
  def put(k: String, v: String): Data831 = copy(meta = meta.updated(k, v))
  def merge(other: Data831): Data831 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data831 {
  given Ordering[Data831] = Ordering.by(_.id)
  def empty: Data831 = Data831(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data831 =
    Data831(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data831] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
