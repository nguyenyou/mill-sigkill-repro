package generated

final case class Data1441(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1441 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1441 = copy(value = value * k)
  def addTag(t: String): Data1441 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1441 = copy(meta = meta.updated(k, v))
  def merge(other: Data1441): Data1441 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1441 {
  given Ordering[Data1441] = Ordering.by(_.id)
  def empty: Data1441 = Data1441(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1441 =
    Data1441(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1441] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
