package generated

final case class Data859(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data859 = copy(name = name.toUpperCase)
  def scale(k: Double): Data859 = copy(value = value * k)
  def addTag(t: String): Data859 = copy(tags = t :: tags)
  def put(k: String, v: String): Data859 = copy(meta = meta.updated(k, v))
  def merge(other: Data859): Data859 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data859 {
  given Ordering[Data859] = Ordering.by(_.id)
  def empty: Data859 = Data859(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data859 =
    Data859(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data859] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
