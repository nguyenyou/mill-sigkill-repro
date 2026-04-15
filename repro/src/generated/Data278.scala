package generated

final case class Data278(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data278 = copy(name = name.toUpperCase)
  def scale(k: Double): Data278 = copy(value = value * k)
  def addTag(t: String): Data278 = copy(tags = t :: tags)
  def put(k: String, v: String): Data278 = copy(meta = meta.updated(k, v))
  def merge(other: Data278): Data278 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data278 {
  given Ordering[Data278] = Ordering.by(_.id)
  def empty: Data278 = Data278(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data278 =
    Data278(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data278] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
