package generated

final case class Data447(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data447 = copy(name = name.toUpperCase)
  def scale(k: Double): Data447 = copy(value = value * k)
  def addTag(t: String): Data447 = copy(tags = t :: tags)
  def put(k: String, v: String): Data447 = copy(meta = meta.updated(k, v))
  def merge(other: Data447): Data447 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data447 {
  given Ordering[Data447] = Ordering.by(_.id)
  def empty: Data447 = Data447(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data447 =
    Data447(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data447] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
