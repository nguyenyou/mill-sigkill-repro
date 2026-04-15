package generated

final case class Data927(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data927 = copy(name = name.toUpperCase)
  def scale(k: Double): Data927 = copy(value = value * k)
  def addTag(t: String): Data927 = copy(tags = t :: tags)
  def put(k: String, v: String): Data927 = copy(meta = meta.updated(k, v))
  def merge(other: Data927): Data927 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data927 {
  given Ordering[Data927] = Ordering.by(_.id)
  def empty: Data927 = Data927(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data927 =
    Data927(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data927] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
