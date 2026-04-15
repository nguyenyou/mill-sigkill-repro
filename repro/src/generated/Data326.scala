package generated

final case class Data326(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data326 = copy(name = name.toUpperCase)
  def scale(k: Double): Data326 = copy(value = value * k)
  def addTag(t: String): Data326 = copy(tags = t :: tags)
  def put(k: String, v: String): Data326 = copy(meta = meta.updated(k, v))
  def merge(other: Data326): Data326 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data326 {
  given Ordering[Data326] = Ordering.by(_.id)
  def empty: Data326 = Data326(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data326 =
    Data326(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data326] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
