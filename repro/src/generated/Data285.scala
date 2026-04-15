package generated

final case class Data285(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data285 = copy(name = name.toUpperCase)
  def scale(k: Double): Data285 = copy(value = value * k)
  def addTag(t: String): Data285 = copy(tags = t :: tags)
  def put(k: String, v: String): Data285 = copy(meta = meta.updated(k, v))
  def merge(other: Data285): Data285 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data285 {
  given Ordering[Data285] = Ordering.by(_.id)
  def empty: Data285 = Data285(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data285 =
    Data285(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data285] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
