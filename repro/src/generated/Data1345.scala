package generated

final case class Data1345(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1345 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1345 = copy(value = value * k)
  def addTag(t: String): Data1345 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1345 = copy(meta = meta.updated(k, v))
  def merge(other: Data1345): Data1345 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1345 {
  given Ordering[Data1345] = Ordering.by(_.id)
  def empty: Data1345 = Data1345(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1345 =
    Data1345(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1345] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
